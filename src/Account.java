


import javax.swing.*;

    public class Account {


        final String pinNum = "1000";
        private double balance;
         int i = 0;
        int number = 0;
        //static int c;
        static String[] history = new String[5];


       // private int j = 0;


        public void deposit(double amount) {


                balance += amount;
                if (i == 5)
                    i = 0;
                number ++;
                
                history[i++] = number + " : Deposit " + amount;
                //getHistory(1,amount);

            }



        public boolean withdrawal(double y) {
            if (y > balance || y < 0)
                return false;
            balance -= y;
            if (i == 5)
                i = 0;
            number ++;
            history[i++] = number + " : Withdraw " + y;
            //getHistory(2,y);
            return true;
        }


        // fn to get the balance
        public double getBalance() {
            
        	
            //getHistory(3,balance);
            return balance;
        }
        
 public double getBalance2() {
            
	 if (i == 5)
         i = 0;
     number ++;
    
        	history[i++]= "number" + " : Balance"+balance;
            //getHistory(3,balance);
            return balance;
        }

        public boolean ValidatePin(String test) {
            if (test.equals(pinNum))
                return true;
            else
                return false;
        }
         public String getHistory(int c){

          return history[c];
        }
        public int getSize(){
            return i;
        }
       /* public void getHistory(int type, double amount) {


            if(type==1){
                history[i] = String.format("deposit: %f", amount);
                i++;
            }
            else if (type==2){
                history[i] = String.format("withdraw: %f", amount);
                i++;
            }
            else if (type==3){
                history[i] = String.format("balance: %f", amount);
                i++;
            }
            /*if (type.equals("deposit")) {
                history[i] = String.format("deposit: %f", amount);
                i++;
            }
            if (type.equals("withdraw")) {
                history[i] = String.format("withdraw: %f", amount);
                i++;

            }
            if (type.equals("getBalance")) {
                history[i] = String.format("balance: %f", amount);
                i++;
            }*/
       // }

        //public void next(java.awt.event.ActionEvent event){
            //temp = counter;
        //}


        public void exit(){
           System.exit(0);
        }
    }


