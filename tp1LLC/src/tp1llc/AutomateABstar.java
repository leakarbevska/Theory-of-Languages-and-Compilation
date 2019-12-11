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
public class AutomateABstar extends Automate{
    private int[][] _tableTransitions = {{1,2},{2,1},{2,2}};
    

    @Override
    protected void etatInitial() {
        this.etat = 0;
    }

    @Override
    protected boolean etatCourantEstAcceptant() {
        return this.etat == 1;
    }

    /* avec les AFD
    @Override
    protected void etatSuivant(int charCode) {
        switch(this.etat){
            case 0:
                if(charCode == 'a'){
                    this.etat = 1;
                }else{
                    this.etat = 2;
                }
                break;
            case 1:
                if(charCode == 'b'){
                    this.etat = 1;
                }else{
                    this.etat = 2;
                }
                break;
        }
    }*/
    
    /* avec des tableaux*/
        @Override
    protected void etatSuivant(int c) {
        etat = _tableTransitions[etat][c-'a'];
    }
}
