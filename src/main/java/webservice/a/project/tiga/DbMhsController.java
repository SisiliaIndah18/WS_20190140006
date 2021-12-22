/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.a.project.tiga;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Controller
public class DbMhsController {
    
    @CrossOrigin
    @GetMapping(value="mhsjson", produces = {
            MediaType.APPLICATION_JSON_VALUE
        }
    )

    @ResponseBody
    public List<Mahasiswa> getDataMahasiswa(){
        
        List<Mahasiswa> mahasiswa = new ArrayList<>();
        
        MahasiswaJpaController controller = new MahasiswaJpaController();
        
        try {
            mahasiswa = controller.findMahasiswaEntities();
        } catch (Exception e){}
        
        return mahasiswa;
    }
    
    @CrossOrigin
    @GetMapping(value="mhsxml", produces = {
            MediaType.APPLICATION_XML_VALUE
        }
    )

    @ResponseBody
    public List<Mahasiswa> getXML(){
        
        List<Mahasiswa> mahasiswa = new ArrayList<>();
        
        MahasiswaJpaController controller = new MahasiswaJpaController();
        
        try {
            mahasiswa = controller.findMahasiswaEntities();
        } catch (Exception e){}
        
        return mahasiswa;
    }
}
