<script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@latest"> </script>
<script>
    const features = tf.tensor("age", "date_flight", "gender", "region");
    const profiles = firebase.database().ref('profiles'); 

    #
    function createModel()
    {
        var model = tf.sequential();
        model.add(tf.layers.dense({units:8, inputShape:2, activation: 'tanh'}));
        model.add(tf.layers.dense({units:1, activation: 'sigmoid'}));
        model.compile({optimizer: 'sgd', loss: 'binaryCrossentropy', lr:0.1}); 
        return model; 
    }

    var ys = []
    await model.fit(profiles, ys, {
       batchSize: 1,
       epochs: 5000
   }); 

    const convlayer = tf.layers.conv2d({
    inputShape: [0,1,1,1,0,0,0,1,1],
    kernelSize: 5,
    filters: 8,
    strides: 1,
    activation: 'relu',
    kernelInitializer: 'VarianceScaling'
    });

    
    model.add(convlayer);

    
    const model = tf.sequential();

    //create the first layer 
    model.add(tf.layers.conv2d({
    inputShape: [28, 28, 1],
    kernelSize: 5,
    filters: 8,
    strides: 1,
    activation: 'relu',
    kernelInitializer: 'VarianceScaling'
    }));

    //create a max pooling layer 
    model.add(tf.layers.maxPooling2d({
    poolSize: [2, 2],
    strides: [2, 2]
    }));

    //create the second conv layer
    model.add(tf.layers.conv2d({
    kernelSize: 5,
    filters: 16,
    strides: 1,
    activation: 'relu',
    kernelInitializer: 'VarianceScaling'
    }));

    //create a max pooling layer 
    model.add(tf.layers.maxPooling2d({
    poolSize: [2, 2],
    strides: [2, 2]
    }));

    //flatten the layers to use it for the dense layers 
    model.add(tf.layers.flatten());

    //dense layer with output 10 units 
    model.add(tf.layers.dense({
    units: 10,
    kernelInitializer: 'VarianceScaling',
    activation: 'softmax'
    }));

    // Training
    const batch = tf.zeros([BATCH_SIZE,28,28,1]);
    const labels = tf.zeros([BATCH_SIZE, NUM_CLASSES]);

    const h = await model.fit(batch, labels,
            {
              batchSize: BATCH_SIZE,
              validationData: validationData,
              epochs: BATCH_EPOCHs
            }); 


    //get profiles data
    profilesData = ctx.getData(0, 0, 28, 28);

    //convert to tensor 
    const tensor = tf.fromPixels(profilesData);







</script> 
