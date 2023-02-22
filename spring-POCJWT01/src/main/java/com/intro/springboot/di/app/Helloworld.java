package com.intro.springboot.di.app;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import io.jsonwebtoken.*;

@Controller
public class Helloworld {
	
    private static final String KEY = "unique_name";
	
	public String validateToken(String token){
        try {
            if(Objects.isNull(token) || token.isEmpty()){
                return "Error: El token es nulo o esta vacio.";
            }
            else if(Objects.isNull(Jwts.parser().parseClaimsJwt(token.substring(0,
            		token.lastIndexOf(".")+1)).getBody().get(KEY))){
                return "Error: El token no es valido o no contiene los campos "
                		+ "necesarios.";            
            }
            else {
            	return "Todo bien </br>".concat(token);
            }
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | 
        		IllegalArgumentException exception){
            return "Error: El token no es valido: ".concat(exception.getMessage());
        }
	}
	
	
	
	@GetMapping("/")
	@ResponseBody
	public String helloworld(@RequestParam(name="token",required=true, 
		defaultValue="Saludos") String token){
			String respuesta = validateToken(token);
			return respuesta;
	}
}
