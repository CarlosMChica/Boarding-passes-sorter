# Boarding-passes-sorter

### Git commands / git flow workflow

Create ui feature branch:

git checkout -b ui develop

Merge ui feature branch to develop branch and push to origin:

git checkout develop
git merge --no-ff ui
git push origin develop