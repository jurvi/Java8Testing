package com.jjarvela;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by jjarvela on 18/01/17.
 */
@Named
@RequestScoped
public class Hello {
    public String getString() {
        return "textFromBean";
    }
}
