/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Locale;
import javax.ejb.Local;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gottgried
 */
@ManagedBean
@SessionScoped
public class LocalChanger {
    
    private Locale currentLocal = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    
    public LocalChanger(){}
    
    public void changeLocal(String localCode){
        currentLocal = new Locale(localCode);
    }
    
    public Locale getCurrentlocal(){
        return currentLocal;
    }
    
}
