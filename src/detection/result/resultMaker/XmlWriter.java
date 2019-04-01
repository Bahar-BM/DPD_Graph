package detection.result.resultMaker;


import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import detection.result.resultStructureModel.PatternsGroupInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author amirEbrahimi.um@gmail.com
 */
public class XmlWriter implements WriterStrategy{

       
    private STGroupFile stg ;
    private ST st ;    
    
    
    
    @Override
    public String makeResult(PatternsGroupInfo patternsGroupInfo)
    {
        loadTemplate(Constants.TemplatesPath + "xml.stg");
        
        st = stg.getInstanceOf("xmlFile");   
        st.add("PatternsGroupInfo", patternsGroupInfo);
        
        return st.render();       
    }
    
   
    
     /**
     * Considering target language detection.load proper template.
     * @param path 
     */
    public void loadTemplate(String path)
    {
        stg = new STGroupFile(path);        
    }
    

    
}
