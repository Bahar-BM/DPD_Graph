/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class25 implements Class24, Class41 
{
    private ArrayList<Class24> componentList = new ArrayList<Class24>();
    protected Class8 field70 = null;
    public Class134 field71 = null;
    public Class178 field72 = null;

    public Class25()
    {

    }


    public Class25(int arg19)
    {

        field70 = new Class8();
        field71 = new Class134();
        field72 = new Class178();

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
     */
    protected void method122()
    {
        Class42 field779 = new Class42();
        field779.method121(0.4522878773621204, true);

    }

    /**
     *  
     */
    public void method124()
    {
        Class140 field780 = new Class140();
        field780.method123();

    }
}