/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.dao;

import com.judgment.entity.Authority;

/**
 *
 * @author gsnurr3
 */
public interface AuthorityDAO {

    Authority findByName(String name);
}
