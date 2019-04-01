/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class47 implements Class46, Class96 
{
    private ArrayList<Class47> compositeList = new ArrayList<Class47>();
    private ArrayList<Class48> leafList = new ArrayList<Class48>();
    protected Class28 field347 = null;
    public Class40 field348 = null;
    public static Class157 field349 = null;
    public Class163 field350 = null;

    public Class47()
    {

    }


    public Class47(int arg36)
    {

        field347 = new Class28();
        field348 = new Class40();
        field349 = new Class157();
        field350 = new Class163();

    }



    /**
     *  
     */
    public void iMethod11()
    {
        for ( int i = 0 ; i<compositeList.size() ; i = i + 1 )
        {
            compositeList.get(i).iMethod11();

        }
        for ( int j = 0 ; j<leafList.size() ; j = j + 1 )
        {
            leafList.get(j).iMethod11();

        }

    }

    /**
     * 
     * @param composite 
     */
    public void attachComposite(Class47 composite)
    {
        compositeList.add(composite);

    }

    /**
     * 
     * @param composite 
     */
    public void detachComposite(Class47 composite)
    {
        compositeList.remove(composite);

    }

    /**
     * 
     * @param leaf 
     */
    public void attachLeaf(Class48 leaf)
    {
        leafList.add(leaf);

    }

    /**
     * 
     * @param leaf 
     */
    public void detachLeaf(Class48 leaf)
    {
        leafList.remove(leaf);

    }

    /**
     * 
     * @param arg1097 
     */
    public void method155(int arg1097)
    {
    }

    /**
     * 
     * @param arg1273 
     */
    public void method513(float arg1273)
    {
    }

    /**
     *  
     */
    private void method550()
    {
        Class66 field2972 = new Class66();
        field2972.method549();

    }

    /**
     *  
     */
    public void method552()
    {
        Class70 field2973 = new Class70();
        field2973.method551(530301);

    }

    /**
     *  
     */
    private void method554()
    {
        Class92 field2974 = new Class92();
        field2974.method553();

    }

    /**
     *  
     */
    private void method556()
    {
        Class172 field2975 = new Class172();
        field2975.method555(0.43247876124514306);

    }

    /**
     * 
     * @param arg1646 
     */
    public void method1275(double arg1646)
    {
    }

    /**
     *  
     */
    public void method1463()
    {
    }

    /**
     *  
     */
    public void method3489()
    {
    }

    /**
     *  
     */
    public void method3735()
    {
    }

    /**
     * 
     * @param arg3030 
     */
    public void method3945(float arg3030)
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod13()
    {
    }

    /**
     * 
     * @param element 
     */
    @Override
    public void iMethod22(Class98 element)
    {
    }

    /**
     *  
     */
    @Override
    public String iMethod23()
    {
        return "HXTHG5IP";

    }
}