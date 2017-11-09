'## Optimaint_Moniteur.exe [{ID configuration}][,{valeur}[,{société}]]
'##
'## Les arguments mentionnés entourés des caractères '[' et ']' sont facultatifs.
'##
'## • {ID configuration} représente l'identification de la configuration de fonctionnement d'OptiMaint, par défaut la valeur utilisée est 'OptiMaint', 
'## • {valeur} doit correspondre à la valeur 2,
'## • {société} correspond à l'identification de la société pour laquelle doit être lancé le traitement. 
C:
cd "C:\Program Files (x86)\Apisoft\OptiMaint"
OptiMaint_Moniteur.exe OptiMaint,2,11
exit 0