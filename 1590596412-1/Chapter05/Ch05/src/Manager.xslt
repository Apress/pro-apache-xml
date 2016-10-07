<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="customers">
    <xsl:apply-templates select ="customer">
      <xsl:sort select="name" order="ascending"/>
    </xsl:apply-templates>
  </xsl:template>
  <xsl:template match="/customers/customer">
    <Manager>
        <xsl:value-of select="." />
        Manager Approved</Manager>
  </xsl:template>
</xsl:stylesheet>
