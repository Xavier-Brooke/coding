const mongoose = require('mongoose');

const studentSchema = new mongoose.Schema({
    name: String,
    subject: String,
    age: Number
});

const Student = mongoose.model('Student', studentSchema, 'students');

async function main() {
    try {
        await mongoose.connect('mongodb://127.0.0.1:27017/relationships');
        console.log('Successfully connected to DB');

        const students = await Student.find({ subject: 'DM' });
        console.log('Students with subject DM:', students);
    } catch (err) {
        console.log('Something went wrong...');
        console.error(err);
    } finally {
        await mongoose.disconnect();
    }
}

main();