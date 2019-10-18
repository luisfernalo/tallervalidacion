/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import modelado.Persona;

/**
 *
 * @author luis fernando
 */
@Named(value = "controlador")
@RequestScoped
public class Controlador {
    
    private String correo;
    private Persona persona = new Persona();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String submit(){
        return "/success";
    }
    /**
     * Creates a new instance of Controlador
     */
    public Controlador() {
    }
    /**
     * 
     * @param context
     * @param toValidate
     * @param value 
     * creando validaciones por parte del controlador
     */
    public void validarEdad(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        int edad = Integer.parseInt((String) value);
        if(edad<18){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("Mayor a 18 años"));
        }
    }
    public void validarfecha(FacesContext context, UIComponent toValidate, Object value) throws ParseException{
        context = FacesContext.getCurrentInstance();
        Date fecha = new SimpleDateFormat("dd/MM/YYYY").parse((String) value);
        if(fecha==null){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("fecha incorrecta"));
        }
    }
    
}
