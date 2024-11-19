package org.example;

public class ProductCatalog {

    public enum Products {
        /**
         * For this enum will simulate the actual making of garment in seconds
         */
        SKIRT("Skirt", 1000),
        SHIRT("Shirt", 1500),
        PANTS("Pants", 1000),
        COAT("Coat", 2000);

        private final String name;
        private final long sewingTimeInMillis;

        Products(String name, long sewingTimeInMillis) {
            this.name = name;
            this.sewingTimeInMillis = sewingTimeInMillis;
        }

        public String getName() {
            return name;
        }

        public long getSewingTimeInMillis() {
            return sewingTimeInMillis;
        }

        @Override
        public String toString() {
            return STR."Product{name='\{name}', sewingTimeInMillis=\{sewingTimeInMillis}\{'}'}";
        }
    }
}