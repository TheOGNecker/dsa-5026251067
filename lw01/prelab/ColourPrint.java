public class ColourPrint extends PrintJob {
        public ColourPrint (String id, int pages){
            super(id, pages);
        }

        @Override
        public int calculateCharge(){
                int temp = super.getPages();
                int total = 0;
                total = temp * 1500;
                if (temp > 10){
                        total += (temp - 10) * 1000;
                }
                return total + 2000;
        }

        //dont change
        @Override
        public String label(){
                return "Colour";
        }
}
