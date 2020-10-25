package com.github.ammirante.tcc.site.security;

import java.util.Arrays;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;

import org.eclipse.microprofile.jwt.Claims;
import org.jboss.logmanager.Logger;
import org.jose4j.jwt.JwtClaims;

import com.github.ammirante.tcc.site.util.TokenUtils;

/**
 * TokenService
 *
 */
@RequestScoped
public class TokenService {

	public final static Logger LOGGER = Logger.getLogger(TokenService.class.getSimpleName());

	/**
	 * @param email
	 * @param username
	 * @return
	 */
	public String generateUserToken(String email, String username) {
		return generateToken(email, username, Roles.USER);
	}
	
	/**
	 * @param email
	 * @param username
	 * @return
	 */
	public String generateAdminToken(String email, String username) {
		return generateToken(email, username, Roles.ADMIN);
	}

	/**
	 * @param serviceId
	 * @param serviceName
	 * @return
	 */
	public String generateServiceToken(String serviceId, String serviceName) {
		return generateToken(serviceId, serviceName, Roles.SERVICE);
	}

	/**
	 * @param subject
	 * @param name
	 * @param roles
	 * @return
	 */
	public String generateToken(String subject, String name, String... roles) {
		try {
			JwtClaims jwtClaims = new JwtClaims();
			jwtClaims.setIssuer("DonauTech"); // change to your company
			jwtClaims.setJwtId(UUID.randomUUID().toString());
			jwtClaims.setSubject(subject);
			jwtClaims.setClaim(Claims.upn.name(), subject);
			jwtClaims.setClaim(Claims.preferred_username.name(), name); // add more
			jwtClaims.setClaim(Claims.groups.name(), Arrays.asList(roles));
			jwtClaims.setAudience("using-jwt");
			jwtClaims.setExpirationTimeMinutesInTheFuture(60); // TODO specify how long do you need

			String token = TokenUtils.generateTokenString(jwtClaims);
			LOGGER.info("TOKEN generated: " + token);
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
