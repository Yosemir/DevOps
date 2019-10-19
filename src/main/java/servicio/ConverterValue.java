package servicio;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named(value = "converterValue")
@SessionScoped
@FacesConverter("converterValue")
public class ConverterValue implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String TIPPARCAP = "";
        if (value != null) {
            TIPPARCAP = (String) value;
            switch (TIPPARCAP) {
                case "A":
                    TIPPARCAP = "Asistente";
                    break;
                case "D":
                    TIPPARCAP = "Doctor";
                    break;
                case "E":
                    TIPPARCAP = "Enfermera";
                    break;
                case "I":
                    TIPPARCAP = "Interno";
                    break;
                case "X":
                    TIPPARCAP = "Externo";
                    break;
            }
        }
        return TIPPARCAP;
    }

}
