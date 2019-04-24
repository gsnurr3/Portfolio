/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.service;

/**
 *
 * @author gsnurr3
 */
public interface EmailService {

    public void sendRegistrationEmail(String to, String subject, String text);
}
