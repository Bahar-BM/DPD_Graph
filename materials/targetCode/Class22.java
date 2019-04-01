/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class22 extends Class21 implements Class87 
{
    private ArrayList<Class21> componentList = new ArrayList<Class21>();
    private Class44 field46 = null;
    protected Class77 field47 = null;
    protected Class92 field48 = null;
    private Class95 field49 = null;
    protected Class125 field50 = null;
    protected Class134 field51 = null;

    public Class22()
    {

        super(670172);

    }


    public Class22(int arg17)
    {

        super(arg17);
        field46 = new Class44();
        field47 = new Class77();
        field48 = new Class92();
        field49 = new Class95();
        field50 = new Class125();
        field51 = new Class134();

    }



    /**
     *  
     */
    public void operation()
    {
        for ( int i = 0 ; i<componentList.size() ; i = i + 1 )
        {
            componentList.get(i).operation();

        }

    }

    /**
     * 
     * @param component 
     */
    public void attach(Class21 component)
    {
        componentList.add(component);

    }

    /**
     * 
     * @param component 
     */
    public void detach(Class21 component)
    {
        componentList.remove(component);

    }

    /**
     *  
     */
    public void method15()
    {
    }

    /**
     * 
     * @param arg181 
     */
    public void method45(boolean arg181)
    {
    }

    /**
     *  
     */
    protected void method78()
    {
        Class120 field442 = new Class120();
        field442.method77(false);

    }

    /**
     *  
     */
    protected void method80()
    {
        Class123 field443 = new Class123();
        field443.method79(true, 0.11329746f);

    }

    /**
     *  
     */
    private void method82()
    {
        Class138 field444 = new Class138();
        field444.method81(675032);

    }

    /**
     *  
     */
    public void method143()
    {
    }

    /**
     * 
     * @param in 
     */
    @Override
    public void iMethod22(Class84 in)
    {
    }
}