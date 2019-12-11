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
public class AutomateSetABstarBstar extends Automate{
    private int[][] _tableTransitions = {{1,2}, {3,2}, {1,2}, {3,3}};
    
        
    @Override
    protected void etatInitial() {
        this.etat = 0;
    }

    @Override
    protected boolean etatCourantEstAcceptant() {
        return this.etat == 0 || this.etat == 2;
    }

    /*@Override
    protected void etatSuivant(int charCode) {
        switch(this.etat){
            case 0:
                if(charCode == 'a'){
                    this.etat = 1;
                }else if(charCode == 'b'){
                    this.etat = 2;
                }else{
                    this.etat = 3;
                }
                break;
            case 1:
                if(charCode == 'b'){
                    this.etat = 2;
                }else{
                    this.etat = 3;
                }
                break;
            case 2:
                if(charCode != 'b')
                    this.etat = 3;
                break;
        }
    }*/
    
    @Override
    protected void etatSuivant(int c) {
        etat = _tableTransitions[etat][c-'a'];
    }  
        
}
