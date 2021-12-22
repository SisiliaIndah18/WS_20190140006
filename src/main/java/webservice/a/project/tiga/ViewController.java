/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.a.project.tiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
    
    @RequestMapping("/tabel")
    public String getTabel (Model model, HttpServletRequest cari){
        
       String nama_barang_dicari = cari.getParameter("barang");
       String nama_ketemu = "";
       List<String> buffer = new ArrayList<>();
       
       ArrayList<List<String>> tabel_harga = new ArrayList<>();
       ArrayList<List<String>> tabel_baru = new ArrayList<>();
       
       tabel_harga.add(Arrays.asList("Telur", "1000"));
       tabel_harga.add(Arrays.asList("Mie x", "2500"));
       tabel_harga.add(Arrays.asList("Pensil", "4500"));
       tabel_harga.add(Arrays.asList("Tipex", "6500"));
       
       for (int brs=0; brs<tabel_harga.size(); brs++){
           buffer = tabel_harga.get(brs);
           if (buffer.toString().contains(nama_barang_dicari)){
               tabel_baru.add(tabel_harga.get(brs));
           } else {nama_ketemu="Tidak Ditemukan";}
       }
       
       model.addAttribute("tabel_baru", tabel_baru);
       model.addAttribute("barangdicari", nama_ketemu);
       return "viewTabel";
    }
    
    @RequestMapping("/hapus")
    public String deleteData(Model model, HttpServletRequest hapus){
        String nama_barang_dihapus = hapus.getParameter("barang");
        String nama_ketemu = "";
        List<String> buffer = new ArrayList<>();
        ArrayList<List<String>> tabel_harga = new ArrayList<>();
        ArrayList<List<String>> tabel_baru = new ArrayList<>();
        
        tabel_harga.add(Arrays.asList("Telur", "1000"));
        tabel_harga.add(Arrays.asList("Mie x", "2500"));
        tabel_harga.add(Arrays.asList("Pensil", "4500"));
        tabel_harga.add(Arrays.asList("Tipex", "6500"));
        
        for (int brs=0; brs<tabel_harga.size(); brs++){
           buffer = tabel_harga.get(brs);
           if (buffer.toString().contains(nama_barang_dihapus)){
               tabel_baru.remove(tabel_harga.get(brs));
           } else {nama_ketemu="Tidak Ditemukan";}
       }
       
       model.addAttribute("tabel_baru", tabel_baru);
       model.addAttribute("barangdicari", nama_ketemu);
       return "viewTabel";
    }
    
    @RequestMapping("/data/minuman")
    @ResponseBody
    
    public ArrayList<String> getMinuman(){
        
        ArrayList<String> data = new ArrayList<>();
        
        data.add("Kopi");
        data.add("Susu");
        data.add("Teh");
        
        return data;
    }
    
    @RequestMapping("/data/boyfie")
    @ResponseBody
    
    public HashMap <String,String> getBoyfie(){
        
        HashMap<String,String> map = new HashMap<>();
        
        map.put("EXO", "Oh Sehun");
        map.put("NCT", "Jung Jaehyun, Na Jaemin, Xiao De Jun");
        map.put("ENHYPEN", "Sim Jae Yun");
        
        return map;
    }
    
    @RequestMapping("/data/cuaca")
    @ResponseBody
    
    public HashMap <String,Integer> getRamalan(){
        
        HashMap<String,Integer> map = new HashMap<>();
        
        map.put("suhu", 26);
        map.put("Kelembaban", 30);
        map.put("Tekanan", 3);
        
        return map;
    }
    
    /**
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(value="data/pribadi", produces = {
           MediaType.APPLICATION_JSON_VALUE
        }
    )
    
    @ResponseBody
    public HashMap<String, String> getXML(){
        
        HashMap<String, String> map = new HashMap<>();
        map.put("Nama", "Sisilia Indah Lestari");
        map.put("Alamat", "20190140006");
        map.put("Collage", "UMY");
        
        return map;
    }
    
}
