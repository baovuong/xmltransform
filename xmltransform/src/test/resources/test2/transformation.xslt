<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" indent="yes"/>
	<xsl:template match="/persons">
		<!-- TODO: Auto-generated template -->
		<names>
			<xsl:apply-templates select="person"/>
		</names>
	</xsl:template>
	
	<xsl:template match="person">
		<name><xsl:value-of select="name"/><xsl:text> </xsl:text><xsl:value-of select="family-name"/></name>
	</xsl:template>
</xsl:stylesheet>