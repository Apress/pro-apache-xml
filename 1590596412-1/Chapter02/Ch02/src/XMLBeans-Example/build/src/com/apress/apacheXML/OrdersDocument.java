/*
 * An XML document type.
 * Localname: Orders
 * Namespace: http://www.apress.com/apacheXML
 * Java type: com.apress.apacheXML.OrdersDocument
 *
 * Automatically generated - do not modify.
 */
package com.apress.apacheXML;


/**
 * A document containing one Orders(@http://www.apress.com/apacheXML) element.
 *
 * This is a complex type.
 */
public interface OrdersDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schemaorg_apache_xmlbeans.system.s1C5926A05B682DD0CA6863A5E68E1970.TypeSystemHolder.typeSystem.resolveHandle("orders24f6doctype");
    
    /**
     * Gets the "Orders" element
     */
    com.apress.apacheXML.OrdersDocument.Orders getOrders();
    
    /**
     * Sets the "Orders" element
     */
    void setOrders(com.apress.apacheXML.OrdersDocument.Orders orders);
    
    /**
     * Appends and returns a new empty "Orders" element
     */
    com.apress.apacheXML.OrdersDocument.Orders addNewOrders();
    
    /**
     * An XML Orders(@http://www.apress.com/apacheXML).
     *
     * This is a complex type.
     */
    public interface Orders extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schemaorg_apache_xmlbeans.system.s1C5926A05B682DD0CA6863A5E68E1970.TypeSystemHolder.typeSystem.resolveHandle("ordersa875elemtype");
        
        /**
         * Gets array of all "Customer" elements
         */
        com.apress.apacheXML.OrdersDocument.Orders.Customer[] getCustomerArray();
        
        /**
         * Gets ith "Customer" element
         */
        com.apress.apacheXML.OrdersDocument.Orders.Customer getCustomerArray(int i);
        
        /**
         * Returns number of "Customer" element
         */
        int sizeOfCustomerArray();
        
        /**
         * Sets array of all "Customer" element
         */
        void setCustomerArray(com.apress.apacheXML.OrdersDocument.Orders.Customer[] customerArray);
        
        /**
         * Sets ith "Customer" element
         */
        void setCustomerArray(int i, com.apress.apacheXML.OrdersDocument.Orders.Customer customer);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Customer" element
         */
        com.apress.apacheXML.OrdersDocument.Orders.Customer insertNewCustomer(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Customer" element
         */
        com.apress.apacheXML.OrdersDocument.Orders.Customer addNewCustomer();
        
        /**
         * Removes the ith "Customer" element
         */
        void removeCustomer(int i);
        
        /**
         * An XML Customer(@http://www.apress.com/apacheXML).
         *
         * This is a complex type.
         */
        public interface Customer extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schemaorg_apache_xmlbeans.system.s1C5926A05B682DD0CA6863A5E68E1970.TypeSystemHolder.typeSystem.resolveHandle("customer628felemtype");
            
            /**
             * Gets array of all "StockSymbol" elements
             */
            com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol[] getStockSymbolArray();
            
            /**
             * Gets ith "StockSymbol" element
             */
            com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol getStockSymbolArray(int i);
            
            /**
             * Returns number of "StockSymbol" element
             */
            int sizeOfStockSymbolArray();
            
            /**
             * Sets array of all "StockSymbol" element
             */
            void setStockSymbolArray(com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol[] stockSymbolArray);
            
            /**
             * Sets ith "StockSymbol" element
             */
            void setStockSymbolArray(int i, com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol stockSymbol);
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "StockSymbol" element
             */
            com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol insertNewStockSymbol(int i);
            
            /**
             * Appends and returns a new empty value (as xml) as the last "StockSymbol" element
             */
            com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol addNewStockSymbol();
            
            /**
             * Removes the ith "StockSymbol" element
             */
            void removeStockSymbol(int i);
            
            /**
             * Gets the "ID" attribute
             */
            java.lang.String getID();
            
            /**
             * Gets (as xml) the "ID" attribute
             */
            org.apache.xmlbeans.XmlString xgetID();
            
            /**
             * Sets the "ID" attribute
             */
            void setID(java.lang.String id);
            
            /**
             * Sets (as xml) the "ID" attribute
             */
            void xsetID(org.apache.xmlbeans.XmlString id);
            
            /**
             * An XML StockSymbol(@http://www.apress.com/apacheXML).
             *
             * This is a complex type.
             */
            public interface StockSymbol extends org.apache.xmlbeans.XmlObject
            {
                public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)schemaorg_apache_xmlbeans.system.s1C5926A05B682DD0CA6863A5E68E1970.TypeSystemHolder.typeSystem.resolveHandle("stocksymbol8835elemtype");
                
                /**
                 * Gets the "Quantity" element
                 */
                short getQuantity();
                
                /**
                 * Gets (as xml) the "Quantity" element
                 */
                org.apache.xmlbeans.XmlUnsignedByte xgetQuantity();
                
                /**
                 * Sets the "Quantity" element
                 */
                void setQuantity(short quantity);
                
                /**
                 * Sets (as xml) the "Quantity" element
                 */
                void xsetQuantity(org.apache.xmlbeans.XmlUnsignedByte quantity);
                
                /**
                 * Gets the "TradeType" element
                 */
                java.lang.String getTradeType();
                
                /**
                 * Gets (as xml) the "TradeType" element
                 */
                org.apache.xmlbeans.XmlString xgetTradeType();
                
                /**
                 * Sets the "TradeType" element
                 */
                void setTradeType(java.lang.String tradeType);
                
                /**
                 * Sets (as xml) the "TradeType" element
                 */
                void xsetTradeType(org.apache.xmlbeans.XmlString tradeType);
                
                /**
                 * A factory class with static methods for creating instances
                 * of this type.
                 */
                
                public static final class Factory
                {
                    public static com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol newInstance() {
                      return (com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                    
                    public static com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol newInstance(org.apache.xmlbeans.XmlOptions options) {
                      return (com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                    
                    private Factory() { } // No instance of this class allowed
                }
            }
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static com.apress.apacheXML.OrdersDocument.Orders.Customer newInstance() {
                  return (com.apress.apacheXML.OrdersDocument.Orders.Customer) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static com.apress.apacheXML.OrdersDocument.Orders.Customer newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (com.apress.apacheXML.OrdersDocument.Orders.Customer) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.apress.apacheXML.OrdersDocument.Orders newInstance() {
              return (com.apress.apacheXML.OrdersDocument.Orders) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.apress.apacheXML.OrdersDocument.Orders newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.apress.apacheXML.OrdersDocument.Orders) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.apress.apacheXML.OrdersDocument newInstance() {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.apress.apacheXML.OrdersDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.apress.apacheXML.OrdersDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.apress.apacheXML.OrdersDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.apress.apacheXML.OrdersDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.apress.apacheXML.OrdersDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.apress.apacheXML.OrdersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
