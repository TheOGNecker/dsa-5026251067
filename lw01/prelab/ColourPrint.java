public class ColourPrint extends PrintJob {
        public ColourPrint (String id, int pages){
            super(id, pages);
        }

        @Override
        public int calculateCharge(){
                int temp = super.getPages();
                
                if (temp > 10){
                        return 15000 + (temp - 10) * 1000 + 2000;
                }
                else{
                        return temp * 1500 + 2000;
                }
        }

        //dont change
        @Override
        public String label(){
                return "Colour";
        }
}
