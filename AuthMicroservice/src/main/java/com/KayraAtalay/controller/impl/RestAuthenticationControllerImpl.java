package com.KayraAtalay.controller.impl;

import com.KayraAtalay.dto.request.AuthRequest;
import com.KayraAtalay.dto.request.RefreshTokenRequest;
import com.KayraAtalay.dto.response.AuthResponse;
import com.KayraAtalay.dto.response.DtoUser;
import com.KayraAtalay.shared.response.RestBaseController;
import com.KayraAtalay.shared.response.RootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KayraAtalay.controller.IRestAuthenticationController;

import com.KayraAtalay.service.IAuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/expense-tracker")
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest request) {
        return ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        return ok(authenticationService.refreshToken(request));
    }

}
