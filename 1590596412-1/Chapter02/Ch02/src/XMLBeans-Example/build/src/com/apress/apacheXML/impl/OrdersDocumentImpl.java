/*
 * An XML document type.
 * Localname: Orders
 * Namespace: http://www.apress.com/apacheXML
 * Java type: com.apress.apacheXML.OrdersDocument
 *
 * Automatically generated - do not modify.
 */
package com.apress.apacheXML.impl;
/**
 * A document containing one Orders(@http://www.apress.com/apacheXML) element.
 *
 * This is a complex type.
 */
public class OrdersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.apress.apacheXML.OrdersDocument
{
    
    public OrdersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORDERS$0 = 
        new javax.xml.namespace.QName("http://www.apress.com/apacheXML", "Orders");
    
    
    /**
     * Gets the "Orders" element
     */
    public com.apress.apacheXML.OrdersDocument.Orders getOrders()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.apress.apacheXML.OrdersDocument.Orders target = null;
            target = (com.apress.apacheXML.OrdersDocument.Orders)get_store().find_element_user(ORDERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Orders" element
     */
    public void setOrders(com.apress.apacheXML.OrdersDocument.Orders orders)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.apress.apacheXML.OrdersDocument.Orders target = null;
            target = (com.apress.apacheXML.OrdersDocument.Orders)get_store().find_element_user(ORDERS$0, 0);
            if (target == null)
            {
                target = (com.apress.apacheXML.OrdersDocument.Orders)get_store().add_element_user(ORDERS$0);
            }
            target.set(orders);
        }
    }
    
    /**
     * Appends and returns a new empty "Orders" element
     */
    public com.apress.apacheXML.OrdersDocument.Orders addNewOrders()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.apress.apacheXML.OrdersDocument.Orders target = null;
            target = (com.apress.apacheXML.OrdersDocument.Orders)get_store().add_element_user(ORDERS$0);
            return target;
        }
    }
    /**
     * An XML Orders(@http://www.apress.com/apacheXML).
     *
     * This is a complex type.
     */
    public static class OrdersImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.apress.apacheXML.OrdersDocument.Orders
    {
        
        public OrdersImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CUSTOMER$0 = 
            new javax.xml.namespace.QName("http://www.apress.com/apacheXML", "Customer");
        
        
        /**
         * Gets array of all "Customer" elements
         */
        public com.apress.apacheXML.OrdersDocument.Orders.Customer[] getCustomerArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CUSTOMER$0, targetList);
                com.apress.apacheXML.OrdersDocument.Orders.Customer[] result = new com.apress.apacheXML.OrdersDocument.Orders.Customer[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Customer" element
         */
        public com.apress.apacheXML.OrdersDocument.Orders.Customer getCustomerArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.apress.apacheXML.OrdersDocument.Orders.Customer target = null;
                target = (com.apress.apacheXML.OrdersDocument.Orders.Customer)get_store().find_element_user(CUSTOMER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Customer" element
         */
        public int sizeOfCustomerArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CUSTOMER$0);
            }
        }
        
        /**
         * Sets array of all "Customer" element
         */
        public void setCustomerArray(com.apress.apacheXML.OrdersDocument.Orders.Customer[] customerArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(customerArray, CUSTOMER$0);
            }
        }
        
        /**
         * Sets ith "Customer" element
         */
        public void setCustomerArray(int i, com.apress.apacheXML.OrdersDocument.Orders.Customer customer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.apress.apacheXML.OrdersDocument.Orders.Customer target = null;
                target = (com.apress.apacheXML.OrdersDocument.Orders.Customer)get_store().find_element_user(CUSTOMER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(customer);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Customer" element
         */
        public com.apress.apacheXML.OrdersDocument.Orders.Customer insertNewCustomer(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.apress.apacheXML.OrdersDocument.Orders.Customer target = null;
                target = (com.apress.apacheXML.OrdersDocument.Orders.Customer)get_store().insert_element_user(CUSTOMER$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Customer" element
         */
        public com.apress.apacheXML.OrdersDocument.Orders.Customer addNewCustomer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.apress.apacheXML.OrdersDocument.Orders.Customer target = null;
                target = (com.apress.apacheXML.OrdersDocument.Orders.Customer)get_store().add_element_user(CUSTOMER$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Customer" element
         */
        public void removeCustomer(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CUSTOMER$0, i);
            }
        }
        /**
         * An XML Customer(@http://www.apress.com/apacheXML).
         *
         * This is a complex type.
         */
        public static class CustomerImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.apress.apacheXML.OrdersDocument.Orders.Customer
        {
            
            public CustomerImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName STOCKSYMBOL$0 = 
                new javax.xml.namespace.QName("http://www.apress.com/apacheXML", "StockSymbol");
            private static final javax.xml.namespace.QName ID$2 = 
                new javax.xml.namespace.QName("", "ID");
            
            
            /**
             * Gets array of all "StockSymbol" elements
             */
            public com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol[] getStockSymbolArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List targetList = new java.util.ArrayList();
                    get_store().find_all_element_users(STOCKSYMBOL$0, targetList);
                    com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol[] result = new com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "StockSymbol" element
             */
            public com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol getStockSymbolArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol target = null;
                    target = (com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol)get_store().find_element_user(STOCKSYMBOL$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    return target;
                }
            }
            
            /**
             * Returns number of "StockSymbol" element
             */
            public int sizeOfStockSymbolArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(STOCKSYMBOL$0);
                }
            }
            
            /**
             * Sets array of all "StockSymbol" element
             */
            public void setStockSymbolArray(com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol[] stockSymbolArray)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    arraySetterHelper(stockSymbolArray, STOCKSYMBOL$0);
                }
            }
            
            /**
             * Sets ith "StockSymbol" element
             */
            public void setStockSymbolArray(int i, com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol stockSymbol)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol target = null;
                    target = (com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol)get_store().find_element_user(STOCKSYMBOL$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    target.set(stockSymbol);
                }
            }
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "StockSymbol" element
             */
            public com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol insertNewStockSymbol(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol target = null;
                    target = (com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol)get_store().insert_element_user(STOCKSYMBOL$0, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "StockSymbol" element
             */
            public com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol addNewStockSymbol()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol target = null;
                    target = (com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol)get_store().add_element_user(STOCKSYMBOL$0);
                    return target;
                }
            }
            
            /**
             * Removes the ith "StockSymbol" element
             */
            public void removeStockSymbol(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(STOCKSYMBOL$0, i);
                }
            }
            
            /**
             * Gets the "ID" attribute
             */
            public java.lang.String getID()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "ID" attribute
             */
            public org.apache.xmlbeans.XmlString xgetID()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
                    return target;
                }
            }
            
            /**
             * Sets the "ID" attribute
             */
            public void setID(java.lang.String id)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$2);
                    }
                    target.setStringValue(id);
                }
            }
            
            /**
             * Sets (as xml) the "ID" attribute
             */
            public void xsetID(org.apache.xmlbeans.XmlString id)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$2);
                    }
                    target.set(id);
                }
            }
            /**
             * An XML StockSymbol(@http://www.apress.com/apacheXML).
             *
             * This is a complex type.
             */
            public static class StockSymbolImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.apress.apacheXML.OrdersDocument.Orders.Customer.StockSymbol
            {
                
                public StockSymbolImpl(org.apache.xmlbeans.SchemaType sType)
                {
                    super(sType);
                }
                
                private static final javax.xml.namespace.QName QUANTITY$0 = 
                    new javax.xml.namespace.QName("http://www.apress.com/apacheXML", "Quantity");
                private static final javax.xml.namespace.QName TRADETYPE$2 = 
                    new javax.xml.namespace.QName("http://www.apress.com/apacheXML", "TradeType");
                
                
                /**
                 * Gets the "Quantity" element
                 */
                public short getQuantity()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$0, 0);
                      if (target == null)
                      {
                        return 0;
                      }
                      return target.getShortValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "Quantity" element
                 */
                public org.apache.xmlbeans.XmlUnsignedByte xgetQuantity()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlUnsignedByte target = null;
                      target = (org.apache.xmlbeans.XmlUnsignedByte)get_store().find_element_user(QUANTITY$0, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "Quantity" element
                 */
                public void setQuantity(short quantity)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$0, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(QUANTITY$0);
                      }
                      target.setShortValue(quantity);
                    }
                }
                
                /**
                 * Sets (as xml) the "Quantity" element
                 */
                public void xsetQuantity(org.apache.xmlbeans.XmlUnsignedByte quantity)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlUnsignedByte target = null;
                      target = (org.apache.xmlbeans.XmlUnsignedByte)get_store().find_element_user(QUANTITY$0, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlUnsignedByte)get_store().add_element_user(QUANTITY$0);
                      }
                      target.set(quantity);
                    }
                }
                
                /**
                 * Gets the "TradeType" element
                 */
                public java.lang.String getTradeType()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TRADETYPE$2, 0);
                      if (target == null)
                      {
                        return null;
                      }
                      return target.getStringValue();
                    }
                }
                
                /**
                 * Gets (as xml) the "TradeType" element
                 */
                public org.apache.xmlbeans.XmlString xgetTradeType()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TRADETYPE$2, 0);
                      return target;
                    }
                }
                
                /**
                 * Sets the "TradeType" element
                 */
                public void setTradeType(java.lang.String tradeType)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.SimpleValue target = null;
                      target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TRADETYPE$2, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TRADETYPE$2);
                      }
                      target.setStringValue(tradeType);
                    }
                }
                
                /**
                 * Sets (as xml) the "TradeType" element
                 */
                public void xsetTradeType(org.apache.xmlbeans.XmlString tradeType)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.apache.xmlbeans.XmlString target = null;
                      target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TRADETYPE$2, 0);
                      if (target == null)
                      {
                        target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TRADETYPE$2);
                      }
                      target.set(tradeType);
                    }
                }
            }
        }
    }
}
