package util;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtil implements Serializable{
    

    public static HttpSession getSession(){
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return sessao;
    }
    

    public static void setParamSession(String param, Object value){
        getSession().setAttribute(param, value);
    }

    public SessionUtil() {
    }
  
    public static Object getParamSession(String param){
        return getSession().getAttribute(param);
    }
    
    
    public static void removeParamSession(String param){
        getSession().removeAttribute(param);
    }
    
   
    public static void invalidateSession(){
        getSession().invalidate();
    }
    
}