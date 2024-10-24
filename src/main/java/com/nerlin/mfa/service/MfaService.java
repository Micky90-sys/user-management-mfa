package com.nerlin.mfa.service;

import com.nerlin.mfa.util.MFAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MfaService {

    private final MFAUtil mfaUtil;

    @Autowired
    public MfaService(MFAUtil mfaUtil) {
        this.mfaUtil = mfaUtil;
    }

    public String sendMfaCode(String email) throws IOException { // Dichiara l'eccezione IOException
        return mfaUtil.sendVerificationCode(email);
    }

    public boolean verifyMfaCode(String inputCode, String actualCode) {
        return mfaUtil.verifyCode(inputCode, actualCode);
    }
}
