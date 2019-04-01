/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class22 extends Class21 implements Class59 
{
    private ArrayList<Class21> componentList = new ArrayList<Class21>();
    public static Class3 field61 = null;
    public Class36 field62 = null;
    protected static Class62 field63 = null;

    public Class22()
    {

        super(766104);

    }


    public Class22(int arg17)
    {

        super(arg17);
        field61 = new Class3();
        field62 = new Class36();
        field63 = new Class62();

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
     * @param arg213 
     */
    public void method11(boolean arg213)
    {
    }

    /**
     *  
     */
    protected void method114()
    {
        Class81 field775 = new Class81();
        field775.method113(0.5544387713914306);

    }

    /**
     * 
     * @param arg351 
     */
    public void method313(float arg351)
    {
    }

    /**
     *  
     */
    public void method379()
    {
    }

    /**
     * 
     * @param arg451
     * @param arg452 
     */
    public void method517(boolean arg451, String arg452)
    {
    }

    /**
     * 
     * @param arg579 
     */
    public void method829(boolean arg579)
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod3()
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod8()
    {
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