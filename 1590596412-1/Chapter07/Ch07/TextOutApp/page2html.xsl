<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                              xmlns="http://www.w3.org/1999/xhtml">

  <xsl:template match="page">
    <html>
      <head>
        <title>
         <!--<xsl:value-of select="CompanyName"/>-->
        </title>
      </head>
      <body>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="CompanyName">
      <h1 align="right">
        <xsl:apply-templates/>
      </h1>
  </xsl:template>

  <xsl:template match="Security">
    <h2 align="center">
      <xsl:apply-templates/>
    </h2>
  </xsl:template>

  <xsl:template match="Logo">
    <p align="center">
      <img src="file:///ais.jpg" width="150" height="104"/>
    </p>
  </xsl:template>

</xsl:stylesheet>
