package detection.result.resultMaker;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import detection.result.resultStructureModel.PatternsGroupInfo;

/**
 *
 * @author amirEbrahimi.um@gmail.com
 */
public interface WriterStrategy
{
    
    public String makeResult(PatternsGroupInfo patternsGroupInfo);
}
