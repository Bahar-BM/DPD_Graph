/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class29 implements Class28 
{
    private ArrayList<Class29> compositeList = new ArrayList<Class29>();
    private ArrayList<Class30> leafList = new ArrayList<Class30>();
    protected Class69 field64 = null;
    private Class86 field65 = null;
    public Class97 field66 = null;
    public Class117 field67 = null;
    public Class118 field68 = null;
    private Class144 field69 = null;

    public Class29()
    {

    }


    public Class29(int arg22, Class105 arg152)
    {

        field64 = new Class69();
        field65 = new Class86();
        field66 = new Class97();
        field67 = new Class117();
        field68 = new Class118(arg152);
        field69 = new Class144();

    }



    /**
     *  
     */
    public void iMethod7()
    {
        for ( int i = 0 ; i<compositeList.size() ; i = i + 1 )
        {
            compositeList.get(i).iMethod7();

        }
        for ( int j = 0 ; j<leafList.size() ; j = j + 1 )
        {
            leafList.get(j).iMethod7();

        }

    }

    /**
     * 
     * @param composite 
     */
    public void attachComposite(Class29 composite)
    {
        compositeList.add(composite);

    }

    /**
     * 
     * @param composite 
     */
    public void detachComposite(Class29 composite)
    {
        compositeList.remove(composite);

    }

    /**
     * 
     * @param leaf 
     */
    public void attachLeaf(Class30 leaf)
    {
        leafList.add(leaf);

    }

    /**
     * 
     * @param leaf 
     */
    public void detachLeaf(Class30 leaf)
    {
        leafList.remove(leaf);

    }

    /**
     *  
     */
    public void method33()
    {
    }

    /**
     *  
     */
    protected void method110()
    {
        Class78 field458 = new Class78();
        field458.method109(690953);

    }

    /**
     * 
     * @param arg232 
     */
    public void method163(String arg232)
    {
    }

    /**
     * 
     * @param arg266 
     */
    public void method225(int arg266)
    {
    }

    /**
     *  
     */
    public void method463()
    {
    }

    /**
     * 
     * @param arg450 
     */
    public void method631(boolean arg450)
    {
    }
}