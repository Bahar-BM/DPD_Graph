/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class29 extends Class21 implements Class28 
{
    private ArrayList<Class29> compositeList = new ArrayList<Class29>();
    private ArrayList<Class30> leafList = new ArrayList<Class30>();
    public Class49 field81 = null;
    protected static Class56 field82 = null;
    protected static Class101 field83 = null;
    public Class116 field84 = null;

    public Class29()
    {

        super();

    }


    public Class29(int arg22)
    {

        super(arg22);
        field81 = new Class49();
        field82 = new Class56();
        field83 = new Class101();
        field84 = new Class116();

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
    public void method142()
    {
        Class35 field789 = new Class35();
        field789.method141(0.42801317612747214);

    }

    /**
     *  
     */
    private void method144()
    {
        Class49 field790 = new Class49();
        field790.method143(true);

    }

    /**
     *  
     */
    private void method146()
    {
        Class130 field791 = new Class130();
        field791.method145(0.31876993f, "QQDB");

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
}