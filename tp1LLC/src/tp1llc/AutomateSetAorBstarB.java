/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1llc;

/**
 *
 * @author 21711436
 */
public class AutomateSetAorBstarB extends Automate{
    private int[][] _tableTransitions = {{0,1}, {2,1}, {2,1}};
    private String word= "";
    private Action[][] _actionsTransitions = {{()-> {word+="b"; System.out.println(word);},  ()-> {word+="a"; System.out.println(word);}},
        {()-> {word+="b"; System.out.println(word);}, ()-> {word+="a"; System.out.println(word);}},
        {()-> {word+="b"; System.out.println(word);}, ()-> {word+="a"; System.out.println(word);}}
    };
       
    @Override
    protected void etatInitial() {
        this.etat = 0;
    }

    @Override
    protected boolean etatCourantEstAcceptant() {
        return this.etat == 1;
    }

    /*@Override
    protected void etatSuivant(int charCode) {
        switch(this.etat){
            case 0:
                if(charCode == 'a'){
                    this.etat = 0;
                }else if(charCode == 'b'){
                    this.etat = 1;
                
                break;
            case 1:
                if(charCode == 'b'){
                    this.etat = 1;
                }else if(charCode == 'a'){
                    this.etat = 2;
                }
                break;
            case 2:
                if(charCode == 'b')
                    this.etat = 1;
                break;
        }
    }*/
    
    @Override
    protected void etatSuivant(int c) {
        this.etat = this._tableTransitions[etat][c-'a'];
        this._actionsTransitions[etat][c-'a'].run();
    }   
    
}
