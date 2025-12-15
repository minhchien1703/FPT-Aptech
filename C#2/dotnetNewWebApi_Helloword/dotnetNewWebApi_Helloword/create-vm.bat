echo off
set RESOURCE_GROUP=learn-0cb7dc4f-e069-4f30-b7bc-8f518b1a0f31
set LOCATION=westus
set vmName=T2311E-VM1
set USERNAME=T2311E-User1
set IMAGE=WindowsTS
set SIZE=Standard_B1s

az group create --name %RESOURCE_GROUP% --location %LOCATION%

az vm create ^
        --resource_group %RESOURCE_GROUP% ^
        --name %vmName% ^
        --image %Image% ^
        --size %SIZE% ^
        --admin-username %USERNAME% ^
        --location %LOCATION% ^
        --generate-ssh-keys ^

