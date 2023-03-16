package DTO;

public class Hero_DTO_Superpowers {

        //Specific attributes that represent the desired data to be transferred
        private String heroName;
        private String superPower;

        //Constructor that accepts the desired attributes and creates a new instance of the DTO class
        public Hero_DTO_Superpowers(String heroName, String superPower) {
            this.heroName = heroName;
            this.superPower = superPower;
        }

        //Getter and setter that allows the attributes to be accessed and updated
        public String getHeroName() {
            return heroName;
        }

        public void setHeroName(String heroName) {
            this.heroName = heroName;
        }


        public String getSuperPower() {
            return superPower;
        }

        public void setSuperPower(String superPower) {
            this.superPower = superPower;
        }


}
