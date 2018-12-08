package com.netcracker.util;

import java.util.regex.Pattern;

public class Validation {
    private static final String PASSWORD = "990099";
    private static final String MAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";


    public static boolean checkPassword(String pass){
        return PASSWORD.equals(pass);
    }

    //Simple email expression.
    //Doesn't allow numbers in the domain name and doesn't allow for top level domains that are less than 2 or more than 3 letters
    private static boolean checkEmail(String email){
        Pattern patt = Pattern.compile(MAIL_REGEX);
        return patt.matcher(email).matches();
    }

    public static MailErrors checkAllForMail(String email, String subject, String text){
        if (email.isEmpty())
            return MailErrors.MAIL_IS_EMPTY;
        if(!checkEmail(email))
            return MailErrors.MAIL_IS_NOT_VALID;
        if(subject.isEmpty())
            return MailErrors.SUBJECT_IS_EMPTY;
        if (text.isEmpty())
            return MailErrors.TEXT_IS_EMPTY;
        return MailErrors.IS_OK;
    }

    public enum MailErrors{MAIL_IS_EMPTY, MAIL_IS_NOT_VALID, SUBJECT_IS_EMPTY, TEXT_IS_EMPTY, IS_OK}
}
