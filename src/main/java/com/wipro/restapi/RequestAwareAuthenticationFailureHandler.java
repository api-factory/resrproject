package com.wipro.restapi;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class RequestAwareAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler  {

}
