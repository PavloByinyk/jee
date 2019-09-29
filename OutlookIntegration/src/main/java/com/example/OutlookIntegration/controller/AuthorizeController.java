package com.example.OutlookIntegration.controller;

import com.example.OutlookIntegration.model.IdToken;
import com.example.OutlookIntegration.model.TokenResponse;
import com.example.OutlookIntegration.utils.AuthHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @RequestMapping(value="/authorize", method= RequestMethod.POST)
    public String authorize(
            @RequestParam("code") String code,
            @RequestParam("id_token") String idToken,
            @RequestParam("state") UUID state,
            HttpServletRequest request) {
        {
            // Get the expected state value from the session
            HttpSession session = request.getSession();
            UUID expectedState = (UUID) session.getAttribute("expected_state");
            UUID expectedNonce = (UUID) session.getAttribute("expected_nonce");

            // Make sure that the state query parameter returned matches
            // the expected state
            if (state.equals(expectedState)) {
                session.setAttribute("authCode", code);
                session.setAttribute("idToken", idToken);
            } else {
                session.setAttribute("error", "Unexpected state returned from authority.");
            }


            IdToken idTokenObj = IdToken.parseEncodedToken(idToken, expectedNonce.toString());
            if (idTokenObj != null) {
                TokenResponse tokenResponse = AuthHelper.getTokenFromAuthCode(code, idTokenObj.getTenantId());
                session.setAttribute("tokens", tokenResponse);
                session.setAttribute("userConnected", true);
                session.setAttribute("userName", idTokenObj.getName());
                session.setAttribute("userTenantId", idTokenObj.getTenantId());
            } else {
                session.setAttribute("error", "ID token failed validation.");
            }

            return "mail";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/index.html";
    }
}
