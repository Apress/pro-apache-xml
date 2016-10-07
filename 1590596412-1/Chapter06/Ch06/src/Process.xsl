<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
 xmlns:fo="http://www.w3.org/1999/XSL/Format" 
 exclude-result-prefixes="fo">
 <xsl:output method="xml" version="1.0" 
  omit-xml-declaration="no" indent="yes"/>
  
  
  <xsl:template match="customers">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="first" 
        	page-height="29.7cm" 
        	page-width="21cm" 
        	margin-top="2cm" 
        	margin-bottom="2cm" 
        	margin-left="2cm" 
        	margin-right="2cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="first">
        <fo:flow flow-name="xsl-region-body">
          <fo:block font-size="16pt" 
                    font-weight="bold" 
                    space-after="5mm">
          Customer Orders:
          <xsl:value-of select="CustomerOrders"/>
          </fo:block>
          
          <fo:block font-size="10pt">
            <fo:table table-layout="fixed">
            	
            
              <fo:table-column column-width="4cm"/>
              <fo:table-column column-width="3cm"/>
              <fo:table-column column-width="2cm"/>
              <fo:table-column column-width="2cm"/>
              <fo:table-body>
              
               <fo:table-row font-weight="bold" >
	       	<fo:table-cell >
	       	  <fo:block>Name</fo:block>
	      	 </fo:table-cell>
	      	 <fo:table-cell >
	      	   <fo:block>Order</fo:block>
	      	 </fo:table-cell>
	      	 <fo:table-cell >
	      	   <fo:block>Quantity</fo:block>
	      	 </fo:table-cell>
	      	 <fo:table-cell >
	      	   <fo:block>Price</fo:block>
	      	 </fo:table-cell>
     	       </fo:table-row>
              
              
                <xsl:apply-templates/>
              </fo:table-body>
            </fo:table>
          </fo:block>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
 
 
 <xsl:template match="customers/customer[order='AFK']">
    <fo:table-row>
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="name"/>
        </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block>
        <xsl:value-of select="order"/>
        </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="quantity"/>
        </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="price"/>
         </fo:block>
        </fo:table-cell>

    </fo:table-row>
  </xsl:template>
</xsl:stylesheet>
