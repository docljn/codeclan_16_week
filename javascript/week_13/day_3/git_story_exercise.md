# Git Branching

## Practicing using the collaborative features of git

We are going to write a story in which two people are working on a new beginning and ending to the story simultenously on separate feature branches. 
When all the work is done and we merge the feature branches into `develop`, we might need to deal with some merge conflicts. 

Let's start by creating a github repo for our project, with some basic content and a develop branch:

Person One:

1. Create a local directory and do a `git init`
2. Create a new repo on github and add it as the remote of your local directory
3. Create a file called `superhero.txt`
4. Commit & Push to `master` - we now know that the local and remote `master` branch are the same
5. Create a `develop` branch - `git checkout -b develop`
6. Push to `develop` - `git push origin develop` - now we know the local and remote `develop` are the same
7. Add your partner as a contributer on github

Person Two:

1. Accept the contributer invitation
2. Clone repo
3. Checkout `develop` - `git checkout develop` (notice there is no `-b` flag because we are not creating a new branch, the branch already exists)
4. Create a new new feature branch - `git checkout -b feature/add_story` - notice we are branching off of the develop branch
5. Paste in the story text that is out on slack
6. Add and commit the changes
7. Push to the feature branch - `git push origin feature/add_story` - now we know that `feature/add_story` local and remote are the same


### Merging

We are ready to merge our feature branch into develop, but first we have to make sure we have all the latest changes from `develop` that other people might have made.

1. Checkout `develop` - `git checkout develop` - `develop` local and remote might not be the same so…
2. Pull `develop` - `git pull origin develop` - we now know that develop remote and local are the same so we can go ahead with the merge. 

The end goal is having all our changes integrated into develop, but we will start by merging develop into feature and deal with any conflicts in our feature branch (we don't want to risk break anything in develop). Then we can merge back into develop with confidence that everything will be ok.

If there were changes on develop (otherwise jump to step 8):

3. Checkout the feature branch - `git checkout feature/add_story` - we know that local and remote at the same because we just pushed up the changes
4. Merge develop into add_story - `git merge develop` (make sure you are in your feature branch. We want to deal with any conflicts in the feature before merging into develop)
5. Deal with any conflicts
6. Add & Commit 
7. Push to feature branch - `git push origin feature/add_story` - we now know local and remote of our feature are the same

Lastly we want to merge our feature into develop:

8. Checkout `develop` - `git checkout develop`
9. Do a pull on develop just to double check no new changes have been made in the meantime - `git pull origin develop` and as long as there haven't been...
10. Merge `add_story` into develop
11. Push to `develop` - we now know that the local and remote are the same in develop and our feature branch has been merged.

## Two separate feature branches being worked on simultaneously

Each person should:

1. double check they have all the latest changes on develop.
2. make their own feature branch, one called `feature/ending` the other `feature/beginning`. These branches should branch off of `develop`.
3. edit either the beginning or ending of the story and push their feature branch to the remote.
4. work through the above merging process to merge their feature branches into `develop`, so the `develop` branch has both the new beginning and ending.
5. Finally merge `develop` into `master`.
