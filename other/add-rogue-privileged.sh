#/bin/bash!
echo "If the deployment fails make sure that the privilegedserviceaccount service account exists in evil-project"
echo " and also make sure that the privileged scc is added to it 'oc adm policy add-scc-to-user privileged --serviceaccount=privilegedserviceaccount'"
oc login -u evil
oc new-project evil-project
oc project evil-project
oc process -f rogue-privileged.yaml | oc create -f - -n evil-project