const mongoose = require('mongoose') ;

async function main() {
  try {
    await mongoose.connect('mongodb://127.0.0.1:27017/relationships') ;
    console.log("Successfully Connected to DB") ;
  } catch (err) {
    console.error(err);
  }
}

main() ;

mongoose.connection.once('open', async () => {
  try {
    const rawCollection = mongoose.connection.db.collection('students');
    const data = await rawCollection.find({ name : 'Karen Toy' }).toArray();
    console.log(data);
  } catch (err) {
    console.error(err);
  }
});
