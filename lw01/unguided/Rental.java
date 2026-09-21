public abstract class Rental implements Chargable {
        private String id;
        private int days;

        protected Rental(String id, int days){
                this.id = id;
                this.days = days;

                if(days <= 0){
                        throw new IllegalArgumentException("Days must be greater than 0");
                }
        }

        public String getId(){
                return this.id;
        }

        public int getDays(){
                return this.days;
        }

        public abstract int calculateCharge();

        public int calculateCharge(int units){
                return units * calculateCharge();
        };       

        public String label(){
                return "Rental";
        }

        public String summary(int units){
                return id + " | " + label() + " | " + calculateCharge(units);
        }
}
