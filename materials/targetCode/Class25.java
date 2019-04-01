/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class25 extends Class76 implements Class24 
{
    private ArrayList<Class24> componentList = new ArrayList<Class24>();
    protected Class42 field55 = null;

    public Class25()
    {

        super();

    }


    public Class25(int arg19)
    {

        super();
        field55 = new Class42();

    }



    /**
     *  
     */
    public void iMethod6()
    {
        for ( int i = 0 ; i<componentList.size() ; i = i + 1 )
        {
            componentList.get(i).iMethod6();

        }

    }

    /**
     * 
     * @param component 
     */
    public void attach(Class24 component)
    {
        componentList.add(component);

    }

    /**
     * 
     * @param component 
     */
    public void detach(Class24 component)
    {
        componentList.remove(component);

    }

    /**
     * 
     * @param arg178 
     */
    public void method31(boolean arg178)
    {
    }

    /**
     *  
     */
    public void method94()
    {
        Class11 field450 = new Class11();
        field450.method93();

    }

    /**
     *  
     */
    public void method96()
    {
        Class82 field451 = new Class82();
        field451.method95(false);

    }

    /**
     *  
     */
    protected void method98()
    {
        Class138 field452 = new Class138();
        field452.method97();

    }

    /**
     *  
     */
    public void method100()
    {
        Class145 field453 = new Class145();
        field453.method99();

    }

    /**
     * 
     * @param context 
     */
    @Override
    public void iMethod13(Class58 context)
    {
    }
}