<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  >

  <xsl:template match="/">
    <TABLE BORDER="1">
      <TR bgcolor="0x0000ff">
        <TD>
          <font color="#FFFFFF">
            Customer Name
          </font>
        </TD>
        <TD>
          <font color="#FFFFFF">
            Order Scrip
          </font>
        </TD>
        <TD>
          <font color="#FFFFFF">
            Order Quantity
          </font>
        </TD>
        <TD>
          <font color="#FFFFFF">
            Order Price
          </font>
        </TD>
      </TR>
      <xsl:apply-templates select ="customers"/>
    </TABLE>
  </xsl:template>

  <xsl:template match="customers">
    <xsl:apply-templates select ="customer">

      <xsl:sort select="price" order="ascending" data-type="number"/>

    </xsl:apply-templates>
  </xsl:template>
  <xsl:template match="customer">
    <TR>
      <TD>
        <font color="#0000ff" size="+1">
          <xsl:value-of select ="name"/>
        </font>
      </TD>
      <TD bgcolor="#00FFFF">
        <xsl:value-of select="order"/>
      </TD>
      <TD>
        <p align="right">
          <xsl:value-of select="quantity"/>
        </p>
      </TD>
      <TD bgcolor="#00FFFF">
        <p align="right">
          <xsl:value-of select="price"/>
        </p>
      </TD>
    </TR>
  </xsl:template>
</xsl:stylesheet>
