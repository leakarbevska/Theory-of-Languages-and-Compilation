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
/**
 * TestAutomate permet d'instancier un objet Automate étant donné le nom de sa classe.
 * Il lance ensuite la reconnaissance des mots donnés ensuite en argument par l'automate.
 */
public class tp1llc {

    public static void main(String args[]) {
                Automate a = new AutomateABB();
        System.out.println(a.getClass());
        if (args.length < 1) {
            System.err.println("Usage : TestAutomate nom_classe_automate mots ...");
            System.exit(1);
        }

        try {
            Automate automate =  (Automate)Class.forName(args[0]).newInstance();
            for (int i = 1; i < args.length; i++) {
                String arg = args[i];
                boolean r = automate.reconnait(arg);
                System.out.println("\"" + arg + "\"" + (r ? " est" : " n'est pas") + " reconnu "); 
            }
        } catch (ClassNotFoundException e) {
            System.err.println("** Erreur : classe \""+ args[0] + "\" non trouvée");
        } catch (InstantiationException e) {
            System.err.println("** Erreur instanciation classe \""+ args[0] + "\"");
        } catch (IllegalAccessException e) {
            System.err.println("** Erreur constructeur classe \""+ args[0] + "\" non accessible");
        }
    }
}
