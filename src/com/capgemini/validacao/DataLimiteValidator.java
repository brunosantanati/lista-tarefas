package com.capgemini.validacao;



import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.capgemini.validacao.DataLimiteValidator")
public class DataLimiteValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object valor) throws ValidatorException {
		
		Date dataLimite = (Date) valor;
		LocalDate dataLimiteConvertida = dataLimite.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		LocalDate hoje = LocalDate.now();
		
		if(dataLimiteConvertida.isBefore(hoje)) {
			FacesMessage msg = new FacesMessage("Data Limite não pode estar no passado.");
		    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		    throw new ValidatorException(msg);
		}
		
	}

}
