package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    private String tokenParsed;

    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder().setIssuer("API do Fórum do Alura").setSubject(logado.getId().toString()).setIssuedAt(hoje)
                .setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isTokenValido(String token) {
        try {
            parseToken(token);
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(this.tokenParsed);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario() {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(this.tokenParsed).getBody();
        return Long.parseLong(claims.getSubject());
    }

    private void parseToken(String token) {
        this.tokenParsed = null;
        if (!StringUtils.isEmpty(token) && token.startsWith("Bearer "))
            tokenParsed = token.substring(7, token.length());
    }

}
