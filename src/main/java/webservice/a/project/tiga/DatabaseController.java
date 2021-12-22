/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.a.project.tiga;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
public class DatabaseController {
@GetMapping(value="alattulis", produces = {
            //MediaType.APPLICATION_JSON_VALUE
            MediaType.APPLICATION_XML_VALUE
        }
    )
    
    //@RequestMapping("/alattulis")
    @ResponseBody
    //public List<Alatulis> getAlatTulis(){
    public List<Alatulis> getXML(){
        
        List<Alatulis> alattulis = new ArrayList<>();
        
        AlatulisJpaController controller = new AlatulisJpaController();
        
        try {
            alattulis = controller.findAlatulisEntities();
        } catch (Exception e){}
        
        return alattulis;
    }
}
